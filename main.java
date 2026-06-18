class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Nó de suporte para construir a lista de resultado
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // Armazena o "vai um"

        // O loop continua enquanto houver elementos em l1 OU l2 OU um carry restante
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Começa a soma com o carry anterior

            // Se l1 tiver valor, soma e avança
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Se l2 tiver valor, soma e avança
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calcula o novo carry (ex: se sum for 12, carry é 1)
            carry = sum / 10;

            // Cria o novo nó com o dígito das unidades (ex: se sum for 12, sum % 10 é 2)
            current.next = new ListNode(sum % 10);
            
            // Avança o ponteiro da lista de resultado
            current = current.next;
        }

        // Retorna o próximo nó depois do dummyHead, que é o início real do resultado
        return dummyHead.next;
    }
}
