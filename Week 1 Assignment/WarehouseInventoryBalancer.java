public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        for (int q : sectionA) {
            totalA += q;
        }
        for (int q : sectionB) {
            totalB += q;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highest = Integer.MIN_VALUE;
        String section = "";
        int itemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "Section A";
                itemIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "Section B";
                itemIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highest
                + " (" + section + ", Item " + (itemIndex + 1) + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
