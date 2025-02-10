package items;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<String> items;

    public ItemManager() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public String getNextItem() {
        return items.isEmpty() ? null : items.get(0);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }
}