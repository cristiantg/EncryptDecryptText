### Features

- Encrypt/decrypt text files with an encryption_key.

### Execution

- Add the absolute file paths you want to encrypt at the beginning of the *main* method in *Tester.java* and run it with:

***Linux:***

`cd <path_to_git_project>/EncryptDecryptText`

`rm -f src/*.class`

`cd src && javac -cp "../lib/com.sun.mail_1.4.2.jar" *.java`

`java -cp .:../lib/com.sun.mail_1.4.2.jar Tester`

***Eclipse:***

Just run the file *Tester.java*

  

- You will obtain an **encrypted key** that you can use in the future to decrypt the files.

  
  

**AUTHOR**
Cristian Tejedor García <cristian.tejedorgarcia@ru.nl>