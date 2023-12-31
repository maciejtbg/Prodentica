package com.example.prodentica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View

import com.example.prodentica.databinding.ActivityMainBinding
import com.example.prodentica.databinding.ActivityResultBinding
import java.lang.Integer.min
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.spec.KeySpec
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Odczytujemy wartość zeskanowaną z Intentu
        val scannedValue = intent.getStringExtra("scannedValue")

        // Przypisujemy wartość do pola tekstowego (resultTextView)
        binding.encoded.text = scannedValue
        Log.w("DEC","On Create!")

//        binding.decoded.text = decrypt(scannedValue.toString(),"secretkey123456","1234567890123456")

//        binding.decode.setOnClickListener {
//
//        }
        binding.decode.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Log.w("DEC","Decoding...")
                if (scannedValue != null) {
                    binding.decoded.text = aesBase64Decode(scannedValue)
                }            }

        })
    }

//    fun aesBase64Decode(encodedData: String): String {
//        try {
//            val key = "0123456789abcdef0123456789abcdef"
//            val iv = "1234567890123456"
//            val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
//            val keySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
//            val ivSpec = IvParameterSpec(iv.toByteArray(charset("UTF-8")))
//
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
//            val decodedBytes = Base64.decode(encodedData.toByteArray(),0)
//            val decryptedBytes = cipher.doFinal(decodedBytes)
//            return String(decryptedBytes, Charsets.UTF_8)
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return "Error occurred during decryption."
//        }
//    }

    fun aesBase64Decode(encodedData: String): String {
        try {
//            val key = "0123456789abcdef0123456789abcdef"
//            val iv = "1234567890123456"
//            val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
//            val keySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
//            val ivSpec = IvParameterSpec(iv.toByteArray(charset("UTF-8")))
//
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
            val decodedBytes = Base64.decode(encodedData.toByteArray(),0)
//            val decryptedBytes = cipher.doFinal(decodedBytes)
            return String(decodedBytes, Charsets.UTF_8)

        } catch (e: Exception) {
            e.printStackTrace()
            return "Error occurred during decryption."
        }
    }

//    fun decrypt(encryptedText: String): String {
//        try {
//            val key = "0123456789ABCDEF0123456789ABCDEF"
//            val iv = "0123456789ABCDEF"
//            val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
//            val keySpec = SecretKeySpec(key.toByteArray(Charsets.UTF_8), "AES")
//            val ivSpec = IvParameterSpec(iv.toByteArray(Charsets.UTF_8))
//
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
//
//            val encryptedBytes = Base64.decode(encryptedText.toByteArray(Charsets.UTF_8), Base64.DEFAULT)
//            val decryptedBytes = cipher.doFinal(encryptedBytes)
//
//            return String(decryptedBytes, Charsets.UTF_8)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return "Error occurred during decryption."
//        }
//    }
//        fun decrypt(encryptedText: String): String {
//        try {
//            val decryptedBytes = Base64.decode(encryptedText.toByteArray(Charsets.UTF_8), Base64.DEFAULT)
//            return String(decryptedBytes, Charsets.UTF_8)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return "Error occurred during decryption."
//        }
//    }





//    fun decrypt(encrypted: String, key: String, iv: String): String {
//        try {
//            Log.w("TAG", "encrypted:" + encrypted);
//            Log.w("TAG", "key:"+ key);
//            Log.w("TAG", "iv:" + iv);
//
//            val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
//            Log.w("TAG", "cipher:" + cipher);
//
//            val keySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
//            Log.w("TAG", "keySpec:" + keySpec);
//
//            val ivSpec = IvParameterSpec(iv.toByteArray(charset("UTF-8")))
//            Log.w("TAG", "ivSpec:" + ivSpec);
//
//
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
//
//            val encryptedBytes = Base64.decode(encrypted, Base64.DEFAULT)
//            Log.w("TAG", "encryptedBytes:" + encryptedBytes);
//
//            val decryptedBytes = cipher.doFinal(encryptedBytes)
//            Log.w("TAG", "decryptedBytes:" + decryptedBytes);
//
//
//
//            return String(decryptedBytes, charset("UTF-8"))
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return "Error!"
//        }
//    }

//    fun decrypt(encrypted: String): String {
//        try {
//            val key = "secretkey123456"
//            val iv = "1234567890123456"
//            val keyBytes = key.toByteArray(StandardCharsets.UTF_8)
//            val ivBytes = iv.toByteArray(StandardCharsets.UTF_8)
//            val encryptedBytes = encrypted.toByteArray(StandardCharsets.UTF_8)
//
//            val adjustedKeyBytes = ByteArray(32)
//            System.arraycopy(keyBytes, 0, adjustedKeyBytes, 0, min(keyBytes.size, adjustedKeyBytes.size))
//
//
//
//            val keySpec: SecretKey = SecretKeySpec(adjustedKeyBytes, "AES")
//            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
//            val ivSpec = IvParameterSpec(ivBytes)
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
//
//            val decryptedBytes = cipher.doFinal(encryptedBytes)
//            return String(decryptedBytes, StandardCharsets.UTF_8)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return "Error"
//        }
//    }





}


