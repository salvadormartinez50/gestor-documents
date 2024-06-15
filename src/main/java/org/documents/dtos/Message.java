package org.documents.dtos;

public class Message {
    private String code;
    private String messageInCode;

    public String getCode() {
        return this.code;
    }

    public String getMessageInCode() {
        return this.messageInCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessageInCode(String messaje) {
        this.messageInCode = messaje;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Message)) {
            return false;
        } else {
            Message other = (Message)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object thisCode = this.getCode();
                Object otherCode = other.getCode();
                if (thisCode == null) {
                    if (otherCode != null) {
                        return false;
                    }
                } else if (!thisCode.equals(otherCode)) {
                    return false;
                }

                Object thisMessage = this.getMessageInCode();
                Object otherMessage = other.getMessageInCode();
                if (thisMessage == null) {
                    if (otherMessage != null) {
                        return false;
                    }
                } else if (!thisMessage.equals(otherMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Message;
    }

    public int hashCode() {
        int result = 1;
        Object code1 = this.getCode();
        result = result * 59 + (code1 == null ? 43 : code1.hashCode());
        Object message1 = this.getMessageInCode();
        result = result * 59 + (message1 == null ? 43 : message1.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getCode();
        return "Mensaje(codigo=" + var10000 + ", mensaje=" + this.getMessageInCode() + ")";
    }

    public Message(String code, String message) {
        this.code = code;
        this.messageInCode = message;
    }

    public Message() {
    }
}
