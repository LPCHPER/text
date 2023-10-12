package cn.edu.gcu;

public class Project { public static String encrypt(String input) {
    StringBuilder encrypted = new StringBuilder();

    // 将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
    for (int i = 0; i < input.length(); i++) {
        char c = (char) (input.charAt(i) + i + 1 + 3);
        encrypted.append(c);
    }

    // 将字符串的第一位和最后一位调换顺序
    if (encrypted.length() > 1) {
        char firstChar = encrypted.charAt(0);
        char lastChar = encrypted.charAt(encrypted.length() - 1);
        encrypted.setCharAt(0, lastChar);
        encrypted.setCharAt(encrypted.length() - 1, firstChar);
    }

    // 将字符串反转
    encrypted.reverse();

    return encrypted.toString();
}

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder(input);

        // 将字符串反转
        decrypted.reverse();

        // 将字符串的第一位和最后一位调换顺序
        if (decrypted.length() > 1) {
            char firstChar = decrypted.charAt(0);
            char lastChar = decrypted.charAt(decrypted.length() - 1);
            decrypted.setCharAt(0, lastChar);
            decrypted.setCharAt(decrypted.length() - 1, firstChar);
        }

        // 将每个字符的ASCII码减去它在字符串中的位置(1开始)和偏移值3
        //利用for循环
        for (int i = 0; i < decrypted.length(); i++) {
            char c = (char) (decrypted.charAt(i) - i - 1 - 3);
            decrypted.setCharAt(i, c);
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {
    //输出
        String input = "Hello World!";
        String encrypted = encrypt(input);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
