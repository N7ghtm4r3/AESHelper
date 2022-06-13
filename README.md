
# AESHelper

**v1.0.6**

This is a Java-based library useful to cipher communication between client and server.
AESHelper will allow you to cipher your communication by client side, server side or both sides together.
Good use!


## Implementation

Add the JitPack repository to your build file

### Gradle

- Add it in your root build.gradle at the end of repositories

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Add the dependency

```gradle
dependencies {
    implementation 'com.github.N7ghtm4r3:AESHelper:1.0.6'
}
```

### Maven

- Add it in your root build.gradle at the end of repositories

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
- Add the dependency

```xml
<dependency>
    <groupId>com.github.N7ghtm4r3</groupId>
    <artifactId>AESHelper</artifactId>
    <version>1.0.6</version>
</dependency>
```

## 🛠 Skills
- Java

## Usage/Examples

### Generate keys 

```java
//get with CipherHelper.byteToString(ServerCipher.generateIvParameterSpec().getIV()); method
String IV_SPEC = "ciiz/UZ+oRliqYXVogTYfw==";
```

```java
//get with CipherHelper.byteToString(ServerCipher.generateSecretKey().getEncoded()); method
String SECRET_KEY = "ousG/n0Q7UD6bgamAxktgu3nU1jMntv3YuF1g19mb9c="; 
```

### Client 

```java

public class Client {

    public static void main(String[] args) throws Exception {
        ClientCipher cipher = new ClientCipher(IV_SPEC, SECRET_KEY);
        System.out.println(cipher.encryptRequest("your plain text"));
    }

    //output: 26XBx/esnnrehi/GH3tpnQ==

}

```

### Server 

```java

public class Server {

    public static void main(String[] args) throws Exception {
        ServerCipher cipher = new ServerCipher(IV_SPEC, SECRET_KEY);
        System.out.println(cipher.decryptRequest("26XBx/esnnrehi/GH3tpnQ=="));
    }

    //output: your plain text

}

```

## Authors

- [@N7ghtm4r3](https://www.github.com/N7ghtm4r3)


## Support

For support, email infotecknobitcompany@gmail.com.


## Badges

[![](https://img.shields.io/badge/Google_Play-414141?style=for-the-badge&logo=google-play&logoColor=white)](https://play.google.com/store/apps/developer?id=Tecknobit)
[![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://github.com/N7ghtm4r3/AESHelper/blob/main/README.md)

[![](https://jitpack.io/v/N7ghtm4r3/AESHelper.svg)](https://jitpack.io/#N7ghtm4r3/AESHelper)
[![Twitter](https://img.shields.io/twitter/url/https/twitter.com/cloudposse.svg?style=social&label=Tecknobit)](https://twitter.com/tecknobit)


## Donations 

If you want support project and developer with crypto: **0x5f63cc6d13b16dcf39cd8083f21d50151efea60e**

![](https://img.shields.io/badge/Bitcoin-000000?style=for-the-badge&logo=bitcoin&logoColor=white) 
![](https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white)

If you want support project and developer with <a href="https://www.paypal.com/donate/?hosted_button_id=5QMN5UQH7LDT4">PayPal</a>

Copyright © 2022 Tecknobit
