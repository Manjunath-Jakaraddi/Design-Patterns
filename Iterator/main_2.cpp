#include<iostream>
#include <memory>
#include <ostream>
using namespace std;

class MenuItem {
    string name;
    string description;
    bool vegetarian;
    double price;
public:
    MenuItem() = default;
    MenuItem(string name, string description, bool vegetarian, double price)
    :name(name), description(description), vegetarian(vegetarian), price(price) {}
    
    string getName() {  return name; }
    string getDescription() {  return description; }
    bool isVegetarian() { return vegetarian; }
    double getPrice() { return price; }
};

ostream& operator<<(ostream& os, MenuItem& item) {
    os << "Name : " << item.getName() << "\n";
    os << "Description : " << item.getDescription() << "\n";
    os << "Vegetarian : " << (item.isVegetarian() ? "Yes" : "No") << "\n";
    os << "Price: " << item.getPrice() << "\n\n";
    return os;
} 

class Iterator {
public:
    virtual ~Iterator() = default;
    virtual bool hasNext() = 0;
    virtual shared_ptr<MenuItem> next() = 0;
};

// Similar to Iterable
class Menu {
public:
    virtual ~Menu() = default;
    virtual Iterator* createIterator() = 0;
};

using menu_list = vector<shared_ptr<MenuItem>>;
class PancakeMenuItertor : public Iterator {
    menu_list list;
    int curr_item;
public:
    PancakeMenuItertor(menu_list list) {
        curr_item = 0;
        this->list = list;
    }

    bool hasNext() override {
        return curr_item != list.size();
    }

    shared_ptr<MenuItem> next() override {
        if (hasNext())
            return list.at(curr_item++);
        return nullptr;
    }
};

class PancakeHouseMenu : public Menu {
    menu_list menuItems;
public:
    PancakeHouseMenu() {
        addItem("PanCake Menu Item 1", "Veg Dish 1", true, 123.2);
        addItem("PanCake Menu Item 2", "Non-Veg Dish 1", false, 123.2);
        addItem("PanCake Menu Item 3", "Non-Veg Dish 2", false, 123.2);
        addItem("PanCake Menu Item 4", "Veg Dish 2", true, 123.2);
    }

    void addItem(string name, string description, bool vegetarian, double price) {
        menuItems.push_back(make_shared<MenuItem>(name, description, vegetarian, price));
    }

    // Replace this with Iterator
    // menu_list getMenuItems() {
    //     return menuItems;
    // }
    PancakeMenuItertor* createIterator() override {
        return new PancakeMenuItertor(menuItems);
    }
};

static const int MAX_DINNER_ITEMS = 6;
using dinner_list = array<shared_ptr<MenuItem>, MAX_DINNER_ITEMS>;

class DinnerMenuItertor : public Iterator {
    dinner_list list;
    int curr_item, size;
public:
    DinnerMenuItertor(dinner_list list, size_t size) {
        curr_item = 0;
        this->size = size;
        this->list = list;
    }

    bool hasNext() override {
        return curr_item != size;
    }

    shared_ptr<MenuItem> next() override {
        if (hasNext())
            return list[curr_item++];
        return nullptr;
    }
};

class DinnerMenu : public Menu {
    int num_items = 0;
    dinner_list menuItems;
public:
    DinnerMenu() {
        addItem("Dinner Menu Item 1", "Veg Dish 1", true, 123.2);
        addItem("Dinner Menu Item 2", "Non-Veg Dish 1", false, 123.2);
        addItem("Dinner Menu Item 3", "Non-Veg Dish 2", false, 123.2);
        addItem("Dinner Menu Item 4", "Veg Dish 2", true, 123.2);
    }

    void addItem(string name, string description, bool vegetarian, double price) {
        menuItems[num_items++] = make_shared<MenuItem>(name, description, vegetarian, price);
    }

    // Replace with iterator
    // dinner_list getMenuItems() {
    //     return menuItems;
    // }

    // int getSize() {
    //     return num_items;
    // }
    DinnerMenuItertor* createIterator() override {
        return new DinnerMenuItertor(menuItems, num_items);
    }
};

class Waitress {
    shared_ptr<Menu> pancakeHouseMenu;
    shared_ptr<Menu> dinnerMenu;
public:
    Waitress() {
        pancakeHouseMenu = make_shared<PancakeHouseMenu>();
        dinnerMenu = make_shared<DinnerMenu>();
    }
    // Works on the abstract Iterable Interface rather than concerte Menus
    void printMenu() {
        Iterator* pancakeIterator = pancakeHouseMenu->createIterator();
        Iterator* dinnerMenuIterator = dinnerMenu->createIterator();
        cout << "Menu----Breakfast---\n";
        // printMenu(pancakeIterator);
        // printMenu(dinnerMenuIterator);
        printVegetarian(pancakeIterator);
        printVegetarian(dinnerMenuIterator);
        
        delete pancakeIterator;
        delete dinnerMenuIterator;
    }

    void printVegetarian(Iterator* itr) {
        while (itr->hasNext()) {
            if (itr->next()->isVegetarian())
                cout << *itr->next();
        }
    }

    void printMenu(Iterator* itr) {
        while (itr->hasNext()) {
            cout << *itr->next();
        }
    }
};


int main() {
    Waitress waitress;
    waitress.printMenu();  
    vector<int> list{1, 2, 3, 4};
    vector<int>::const_iterator itr = list.begin();
    while (itr != list.cend())
        cout << *(itr++) << " ";
    cout << endl;
    // c++ way of supporting iterators is through struct iterator in the same class
    // which maintains the internal state through pointer
    // supporting the ++, -- (pre and post operator), * and ->, == and !=
    // and begin(), end() const and non const iterator and rbegin() and rend()
    // etc
    return 0;
}

