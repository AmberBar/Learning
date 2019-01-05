# IO
这个项目是自己复习IO流写的一些case

## IO 流分类

根据角色不同
* 节点流 直接作用在文件上<br>
* 处理流 作用在节点流之上<br>

根据方向
* 输入流<br >
* 输出流

根据数据单位
* 字节流 8bit
* 字符流 16bit

### IO流顶层的四抽象类<br>
| 抽象基类 |字节流 |字符流| 
| :--: | :--: | :--: | 
|输入流|InputStream|Reader |
|输出流|OutputStream|Writer|


节点流: FileInputStream, FileOutputStream,FileReader,FileWriter<br>
处理流: 缓冲流就是处理流的一种(BufferedInputStream,BufferedOutputStram,BufferReader,BufferWriter)<br>

### 处理流
转换流也是处理流的一种
InputStreamReader: 可以把字节流转化成字符流
OutputStreamWriter： 可以把字符流转化成字节流
标准的输入输出流
System.in
System.out
## File
* java.io.file
* File file = new File(XXX);<br>
file可以表示目录，也可以表示文件

