class AlgebraBoolRecursivo {
    static int algebra(String params, int[] valor, int[] pos) {
        char operador = params.charAt(pos[0]);
        pos[0]++; 
        int resultado = 0;
        if (operador == '(') {
            resultado = algebra(params, valor, pos);
            char operacao = params.charAt(pos[0]-1);
            pos[0]++; 

            while (params.charAt(pos[0]) != ')') {
                int proximoValor = algebra(params, valor, pos);

                if (operacao == 't') {
                    resultado = resultado == 0 ? 1 : 0;
                } else if (operacao == 'd') {
                    resultado = resultado + proximoValor == 2  ? 1 : 0;
                } else if (operacao == 'r') {
                    resultado = resultado + proximoValor >0 ? 1 : 0;
                }

                operacao = params.charAt(pos[0]);
                pos[0]++;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        String params;
        params = MyIO.readLine();
        while (params.charAt(0) != '0') {
            int qtdeElementos = Character.getNumericValue(params.charAt(0));
            int[] valor = new int[qtdeElementos];
            int c = 2;
            for (int i = 0; i < qtdeElementos; i++, c += 2) {
                valor[i] = Character.getNumericValue(params.charAt(c));
            }

            int[] posicao = { 0 }; // Inicializa a posição de forma que possa ser atualizada recursivamente
            int resultado = algebra(params, valor, posicao);
            if (resultado == 0) {
                MyIO.println("1");
            } else {
                MyIO.println("0");
            }
            params = MyIO.readLine();
        }
    }
}

