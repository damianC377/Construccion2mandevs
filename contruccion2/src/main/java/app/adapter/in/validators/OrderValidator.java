package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderValidator extends SimpleValidator {

    public long orderNumberValidator(String value) throws Exception {
        long number = longValidator("número de orden", value);
        if (number <= 0) throw new Exception("El número de orden debe ser mayor que 0.");
        return number;
    }

    public int itemNumberValidator(String value) throws Exception {
        int item = integerValidator("número de ítem", value);
        if (item < 0) throw new Exception("El número de ítem no puede ser negativo.");
        return item;
    }

    public double costValidator(String value) throws Exception {
        double cost = doubleValidator("costo", value);
        if (cost < 0) throw new Exception("El costo no puede ser negativo.");
        return cost;
    }
}
