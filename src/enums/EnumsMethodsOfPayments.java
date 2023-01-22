package enums;

public enum EnumsMethodsOfPayments {
    CREDIT ("Credit card", 1),
    DEBIT("Debit card", 2),
    CASH("Payment in Cash at the Entrance", 3),
    PIX ("Instant Payment by PIX", 4),
    BANKTRANSFER ("Payment by Bank Transfer like TED or DOC", 5),
    BANKSLIP("Payment via billet", 6);

    private String description;
    private int id;

    EnumsMethodsOfPayments(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public static EnumsMethodsOfPayments findMethodPaymentById(int id){
        for (EnumsMethodsOfPayments idChoosen: EnumsMethodsOfPayments.values()) {
            if (idChoosen.getId() == id){
                return idChoosen;
            }
        }
        throw new IllegalArgumentException("Invalid option. There is no such payment option");
    }

    @Override
    public String toString() {
        return ", Method of Payment:option "+ getId() +", "+ getDescription();
    }
}
