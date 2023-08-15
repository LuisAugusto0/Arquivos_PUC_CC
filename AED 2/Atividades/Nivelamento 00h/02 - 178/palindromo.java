class palindromo{
    public static boolean isPalindromo(String s, int i) {
        boolean resultado;
        if (i >= s.length() / 2) {
            resultado = true;
        } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            resultado = false;

        } else {
            resultado = isPalindromo(s, i + 1);
        }
        return resultado;
    }

    public static void main(String[] args) {
        String palavra = "radar"; // Exemplo de palavra palíndromo

        if (isPalindromo(palavra, 0)) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo.");
        }
    }
}
