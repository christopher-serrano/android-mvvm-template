package moe.cachapa.android.mvvm.template.utils.library

import android.content.Context
import android.util.Log
import org.koin.core.component.KoinComponent
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder

class CustomFileUtils(val context: Context) : KoinComponent {

    fun getFilename(fileUrl: String): String {
        return fileUrl.substring(fileUrl.lastIndexOf('/') + 1)
    }

    fun createDocumentFile(directory: String, fileName: String): File {
        val destPath = context.getExternalFilesDir(directory)?.path
        destPath?.let {
            checkMakeDirs(it)
        }
        return File("$destPath/$fileName")
    }

    fun checkMakeDirs(dirPath: String): Boolean {
        try {
            val dir = File(dirPath)
            return dir.exists() || dir.mkdirs()
        } catch (e: Exception) {
            Log.e("TAGTAG", e.message!!)
        }
        return false
    }

    fun makeDirs(dirPath: String) {
        try {
            val dir = File(dirPath)
            if (!dir.exists()) {
                dir.mkdirs()
            }
        } catch (e: Exception) {
            Log.e("TAGTAG", e.message!!)
        }
    }

    fun checkFileExists(directory: String, fileName: String): Boolean {
        return try {
            val filePath: String? = context.getExternalFilesDir(directory)?.path
            val file = File("$filePath${File.separator}$fileName")
            file.exists()
        } catch (e: FileNotFoundException) {
            false
        } catch (e: Exception) {
            false
        }
    }

    fun moveFile(source: File, destPath: String?): Boolean {
        if (source.exists()) {
            destPath?.let {
                val dest = File(destPath)
                dest.parent?.let {
                    checkMakeDirs(it)
                }
                try {
                    FileInputStream(source).use { fis ->
                        FileOutputStream(dest).use { fos ->
                            if (!dest.exists()) {
                                dest.createNewFile()
                            }
                            writeToOutputStream(fis, fos)
                            source.delete()
                            return true
                        }
                    }
                } catch (ioE: IOException) {
                    Log.e("TAGTAG", ioE.message!!)
                }
            }
        }
        return false
    }

    fun loadJsonFromAssets(file: String): String? {
        val json: String? = try {
            val inputStream: InputStream = context.assets.open(file)
            inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun readFromFile(directory: String, fileName: String): String? {
        var result = ""
        try {
            val destPath = context.getExternalFilesDir(directory)?.path
            val fileLocation = "$destPath${File.separator}$fileName"
            val inputStream: FileInputStream? = FileInputStream(File(fileLocation))

            Log.d("TAGTAG", "File path: $fileLocation")

            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var receiveString: String?
                val stringBuilder = StringBuilder()
                while (bufferedReader.readLine().also { receiveString = it } != null) {
                    stringBuilder.append(receiveString)
                }
                inputStream.close()
                result = stringBuilder.toString()
            }
        } catch (e: FileNotFoundException) {
            Log.e("readFromFile", "File not found: $e")
        } catch (e: IOException) {
            Log.e("readFromFile", "Can not read file: $e")
        }
        return result
    }

    @Throws(IOException::class)
    private fun writeToOutputStream(inStream: InputStream?, outStream: OutputStream) {
        val buffer = ByteArray(1024)
        var length: Int
        if (inStream != null) {
            while (inStream.read(buffer).also { length = it } > 0x0) {
                outStream.write(buffer, 0x0, length)
            }
        }
        outStream.flush()
    }
}
