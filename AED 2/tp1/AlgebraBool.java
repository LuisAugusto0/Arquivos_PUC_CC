class AlgebraBool {
    static int pos = 0;

    static int algebra(String params) {
        int result = 0;
        int n = params.length();

        while (pos < n) {
            char ch = params.charAt(pos);

            if (ch == '(') {
                pos++; // Avance para o próximo caractere após '('
                int innerResult = algebra(params);

                char operator = params.charAt(pos);
                pos++; // Avance para o próximo caractere após o operador

                if (operator == 'd') {
                    result = (result & innerResult);
                } else if (operator == 'r') {
                    result = (result | innerResult);
                } else if (operator == 't') {
                    result = (result == 0) ? 1 : 0;
                }
            } else if (ch == ')') {
                pos++; // Avance para o próximo caractere após ')'
                break; // Retorna quando encontrar o caractere ')'
            } else if (ch == 'A' || ch == 'B' || ch == 'C') {
                // Substitui A, B e C pelos valores correspondentes
                int index = ch - 'A';
                result = (result | (1 << index));
                pos++; // Avance para o próximo caractere
            } else if (ch == '0') {
                result = 0;
                pos++; // Avance para o próximo caractere
            } else if (ch == '1') {
                result = 1;
                pos++; // Avance para o próximo caractere
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String params;
        params = MyIO.readLine();
        while (params.charAt(0) != '0') {
            pos = 0; // Resetar a posição inicial
            int resultado = algebra(params);
            if (resultado == 0) {
                MyIO.println("1");
            } else {
                MyIO.println("0");
            }
            params = MyIO.readLine();
        }
    }
}

