package practice

import java.io.{BufferedOutputStream, FileOutputStream}
import java.security.{MessageDigest, Security}

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.openpgp.examples.ByteArrayHandler.encrypt


object GPGEncryption extends  App{

//  if(Security.getProvider("BC")==null){
//    Security.addProvider(new BouncyCastleProvider())
//  }
//
//  val original = "I love programming"
//  val myBytes = original.getBytes()
//  val enc = encrypt(myBytes,readPublicKey(new ))

//  val keyRingConfig =  KeyringConfigs.
  val fileOutput = new FileOutputStream("../../resources/encrypted.gpg")
  val bufferedOut = new BufferedOutputStream(fileOutput)
  val outputStream = BouncyGPG

}
