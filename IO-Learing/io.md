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
* 转换流也是处理流的一种
InputStreamReader: 可以把字节流转化成字符流
OutputStreamWriter： 可以把字符流转化成字节流
* 标准的输入输出流
    * System.in
    * System.out
* 打印流
PrintStream
PrintWriter

* 对象流

> 什么是对象序列化机制？
    允许把内存中的java对象转化成和平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上。或者通过网络传输把这种二进制流传输到另一个网络节点。在改网络节点也可把二进制流还原成java对象

ObjectInputStream<br>
ObjectOutputStream<br>
可以用于存取基本数据类型或者对象的处理流
序列化的好处，任何实现了Seriailzable接口的对象转化成字节数据，使其在保存和传输时可以还原

还有一个接口
Externalizable是Serializable的子类
* RandomAccessFile随机存取文件流继承于Object，可以作为输入流也可以作为输出流
输出的时候如果文件不存在，那么创建文件，如果文件存在，那么对文件内容进行覆盖。默认是从头覆盖到

## File
* java.io.file
* File file = new File(XXX);<br>
file可以表示目录，也可以表示文件

## 小知识
* 流资源不会被JVM回收,需要手动关闭


