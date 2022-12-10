package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) != null) {
            Storage.storage.put(transaction.getFruit(),
                    Storage.storage.get(transaction.getFruit()) + transaction.getQuantity());
        } else {
            throw new RuntimeException("Storage is empty");
        }
    }
}