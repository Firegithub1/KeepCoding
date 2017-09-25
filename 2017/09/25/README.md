# 验证 IP 地址的有效性（代码很简单，但是看不懂正则表达式！！！）

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017092501.png">

<img src="http://image.renkaigis.com/keepcoding/2017092502.png">

<img src="http://image.renkaigis.com/keepcoding/2017092503.png">

# 鉴别非法电话号码（正则表达式）

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017092504.png">

<img src="http://image.renkaigis.com/keepcoding/2017092505.png">


# 正则表达式中的元字符及其意义

<table>
    <tr>
        <th>元字符</th>
        <th>正则表达式中的写法</th>
        <th>意义</th>
    </tr>
    <tr>
        <td>.</td>
        <td>"."</td>
        <td>代表任意一个字符</td>
    </tr>
    <tr>
        <td>\d</td>
        <td>"\\d"</td>
        <td>代表 0~9 的任何一个数字</td>
    </tr>
    <tr>
        <td>\D</td>
        <td>"\\D"</td>
        <td>代表任何一个非数字字符</td>
    </tr>
    <tr>
        <td>\s</td>
        <td>"\\s"</td>
        <td>代表空白字符，如 '\t'、'\n'</td>
    </tr>
    <tr>
        <td>\S</td>
        <td>"\\S"</td>
        <td>代表非空白字符</td>
    </tr>
    <tr>
        <td>\w</td>
        <td>"\\w"</td>
        <td>代表可用作标识符的字符，但不包括 "$" 符</td>
    </tr>
    <tr>
        <td>\W</td>
        <td>"\\W"</td>
        <td>代表不可用与标识符的字符</td>
    </tr>
    <tr>
        <td>\p{Lower}</td>
        <td>\\p{Lower}</td>
        <td>代表小写字母 { a~z }</td>
    </tr>
    <tr>
        <td>\p{Upper}</td>
        <td>\\p{Upper}</td>
        <td>代表大写字母 { A~Z }</td>
    </tr>
    <tr>
        <td>\p{ASCII}</td>
        <td>\\p{ASCII}</td>
        <td>ASCII 字符</td>
    </tr>
    <tr>
        <td>\p{Alpha}</td>
        <td>\\p{Alpha}</td>
        <td>字母字符</td>
    </tr>
    <tr>
        <td>\p{Digit}</td>
        <td>\\p{Digit}</td>
        <td>十进制数字，即 [0~9]</td>
    </tr>
    <tr>
        <td>\p{Alnum}</td>
        <td>\\p{Alnum}</td>
        <td>数字或字母字符</td>
    </tr>
    <tr>
        <td>\p{Punct}</td>
        <td>\\p{Punct}</td>
        <td>标点符号：!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~</td>
    </tr>
    <tr>
        <td>\p{Graph}</td>
        <td>\\p{Graph}</td>
        <td>可见字符：[\p{Alnum}\p{Punct}]</td>
    </tr>
    <tr>
        <td>\p{Print}</td>
        <td>\\p{Print}</td>
        <td>可打印字符：[\p{Graph}\x20]</td>
    </tr>
    <tr>
        <td>\p{Blank}</td>
        <td>\\p{Blank}</td>
        <td>空格或制表符：[\t]</td>
    </tr>
    <tr>
        <td>\p{Cntrl}</td>
        <td>\\p{Cntrl}</td>
        <td>控制字符：[\x00-\x1F\x7F]</td>
    </tr>
</table>