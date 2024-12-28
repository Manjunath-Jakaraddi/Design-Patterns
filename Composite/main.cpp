#include <algorithm>
#include <exception>
#include<iostream>
#include <memory>
#include <ostream>
#include <cassert>

using namespace std;


class MenuComponent {
public:
    // Composite Methods
    virtual void add(shared_ptr<MenuComponent> menuComponent) { throw "Not Implemented"; }
    virtual void remove(shared_ptr<MenuComponent> menuComponent) { throw "Not Implemented"; }
    virtual shared_ptr<MenuComponent> getChild(int i) { throw "Not Implemented"; }
    
    // "Operation" Methods
    virtual string getName() { throw "Not Implemented"; }
    virtual string getDescription() { throw "Not Implemented"; }
    virtual bool isVegetarian() { throw "Not Implemented"; }
    virtual double getPrice() { throw "Not Implemented"; }
    virtual void print() { throw "Not Implemented"; }
};

class MenuItem : public MenuComponent {
    string name;
    string description;
    bool vegetarian;
    double price;
public:
    MenuItem() = default;
    MenuItem(string name, string description, bool vegetarian, double price)
    :name(name), description(description), vegetarian(vegetarian), price(price) {}
    
    string getName() override {  return name; }
    string getDescription() override {  return description; }
    bool isVegetarian() override { return vegetarian; }
    double getPrice() override { return price; }
    void print() override { 
        cout << "Name : " << getName() << "\n";
        cout << "Description : " << getDescription() << "\n";
        cout << "Vegetarian : " << (isVegetarian() ? "Yes" : "No") << "\n";
        cout << "Price: " << getPrice() << "\n\n";
    }
};

class Menu : public MenuComponent {
    vector<shared_ptr<MenuComponent>> menuComponents;
    string name;
    string description;
public:
    
    Menu(const string& name, const string& description)
        :name(name), description(description) {}
    
    void add(shared_ptr<MenuComponent> menuComponent) override {
        menuComponents.push_back(menuComponent);
    }

    void remove(shared_ptr<MenuComponent> menuComponent) override { 
        auto itr = find(menuComponents.begin(), menuComponents.end(), menuComponent);
        if (itr != menuComponents.end())
            menuComponents.erase(itr);   
    }

    shared_ptr<MenuComponent> getChild(int i) override { 
        assert(i>=0 && i < menuComponents.size());
        return menuComponents.at(i);
    }
    
    string getName() override {  return name; }
    string getDescription() override {  return description; }

    void print() override { 
        cout << "Name : " << getName() << "\n";
        cout << "Description : " << getDescription() << "\n\n";
        for (auto& menuComp : menuComponents) {
            menuComp->print();
        }
    }
};

class Waitress {
    shared_ptr<MenuComponent> allMenus;
public:
    Waitress(shared_ptr<MenuComponent> allMenus) {
        this->allMenus = allMenus;
    }

    void printAllMenu() {
        allMenus->print();
    }
};

int main() {
    shared_ptr<MenuComponent> pancakeMenuHouse = make_shared<Menu>("PANCAKE MENU HOUSE", "Breakfast");
    shared_ptr<MenuComponent> dinerMenu = make_shared<Menu>("DINER MENU", "Lunch");
    shared_ptr<MenuComponent> cafeMenu = make_shared<Menu>("CAFE MENU", "Dinner");
    shared_ptr<MenuComponent> dessertMenu = make_shared<Menu>("DESSERT MENU", "Dessert of course");

    shared_ptr<MenuComponent> allMenus = make_shared<Menu>("ALL MENUS", "All menus combined");
    allMenus->add(pancakeMenuHouse);
    allMenus->add(dinerMenu);
    allMenus->add(cafeMenu);

    // Add menu items here...
    dinerMenu->add(make_shared<MenuItem>(
        "Pasta",
        "Spaghetti with Marinara Sauces etc",
        true,
        123.2
    ));

    // Add submenus here (dessert)
    dinerMenu->add(dessertMenu);

    dessertMenu->add(make_shared<MenuItem>(
        "Apple Pie",
        "Apple pie with flaky crust",
        true,
        12.12
    ));

    Waitress waitress(allMenus);
    waitress.printAllMenu();
}