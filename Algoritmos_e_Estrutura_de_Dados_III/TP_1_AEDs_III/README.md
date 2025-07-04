# TP_1_AEDs_III
Repositório do Trabalho Prático I de Algoritmos e Estrutura de Dados III

#### Membros do grupo:
- Luís Augusto Lima de Oliveira
- Victor Ferraz de Moraes

# Relatório
## Visão geral do grupo sobre o trabalho

Todos os requisitos do trabalho (Inclusão de um novo registro e Alteração de um registro com aumento de tamanho para o reaproveitamento de espaços vazios) foram realizados. Em questão a implementação das novas operações, a mais difícil para o grupo foi a função Update da tabela extensível, que iria realocar o registro para um espaço vazio (caso houvesse) e assim, reaproveitando os espaços vazios.
O maior desafio do grupo foi, na verdade, compreender a lógica do código da tabela Hash Extensível para realizar a implementação dos requisitos.

### Resultados

Os resultados como um todo foram alcançados em partes, visto que o gerenciamento de lixo implementado com tabela Hash Extensível não é possível verificar todas as possibilidades e buscar o espaço vazio mais otimizado.

### Checklist

#### - O que você considerou como perda aceitável para o reuso de espaços vazios, isto é, quais são os critérios para a gestão dos espaços vazios?

<pre> Consideramos como perda aceitável que o registro a ser colocado no espaço vazio tenha pelo menos 40% do tamanho deste espaço. </pre>

#### - O código do CRUD com arquivos de tipos genéricos está funcionando corretamente?

<pre> Sim, o CRUD utilizando arquivos genéricos está implementado e funcional. </pre>

#### - O CRUD tem um índice direto implementado com a tabela hash extensível?

<pre> Sim, essa foi a nossa escolha para realizar os requisitos solicitados. </pre>

#### - A operação de inclusão busca o espaço vazio mais adequado para o novo registro antes de acrescentá-lo ao fim do arquivo?

<pre> Sim, ele realiza uma busca no índice direto e caso haja espaços vazios, ele verifica o tamanho do novo registro para verificar se ele possui pelo menos 40% deste espaço vazio e realiza sua inserção.  </pre>

#### - A operação de alteração busca o espaço vazio mais adequado para o registro quando ele cresce de tamanho antes de acrescentá-lo ao fim do arquivo?

<pre> Em partes, pois ele realiza a verificação de espaços, mas não de todos devido ao funcionamento do Hash Extensível. </pre>

#### - As operações de alteração (quando for o caso) e de exclusão estão gerenciando os espaços vazios para que possam ser reaproveitados?

<pre> Sim, elas estão gerenciando. Porém, assim como citado no tópico anterior, não são buscado todos os espaços vazios do registro.  </pre>

#### - O trabalho está funcionando corretamente?

<pre> Sim, está funcionando. Dentro das limitações que ele possui. </pre>

#### - O trabalho está completo?

<pre> Sim, o trabalho está completo. </pre>

#### - O trabalho é original e não a cópia de um trabalho de um colega?

<pre> Sim, o trabalho foi implemetado usando código desenvolvido pelo grupo utilizando apenas a base disponibilizada pelo Professor no Canvas. </pre>
