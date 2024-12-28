#include <cstddef>
#include<iostream>
#include <memory>

using namespace std;

class State {
public:
    virtual void insertQuarter() = 0;
    virtual void ejectQuarter() = 0;
    virtual void turnCrank() = 0;
    virtual void dispense() = 0;
};

class GumBallMachine {
    shared_ptr<State> soldOutState;
    shared_ptr<State> noQuarterState;
    shared_ptr<State> hasQuarterState;
    shared_ptr<State> soldState;
    shared_ptr<State> winnerState;

    shared_ptr<State> state = soldOutState;
    int count = 0;
public:
    GumBallMachine(int count);

    void setState(shared_ptr<State> state) {
        this->state = state;
    }

    shared_ptr<State> getHasQuarterState() {
        return hasQuarterState;
    }

    shared_ptr<State> getNoQuarterState() {
        return noQuarterState;
    }

    shared_ptr<State> getSoldOutState() {
        return soldOutState;
    }

    shared_ptr<State> getSoldState() {
        return soldState;
    }

    shared_ptr<State> getWinnerState() {
        return winnerState;
    }

    void insertQuarter() {
        state->insertQuarter();
    }

    void ejectQuarter() {
        state->ejectQuarter();
    }

    void turnCrank() {
        state->turnCrank();
        state->dispense();
    }

    void releaseBall() {
        cout << "A gumball comes rolling out the slot...\n";
        if (count > 0) {
            count--;
        }
    }

    int getCount() {
        return count;
    }
};

class NoQuarterState : public State {
    GumBallMachine* gumballMachine;
public:
    NoQuarterState(GumBallMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }

    void insertQuarter() {
        cout << "You inserted a quarter\n";
        gumballMachine->setState(gumballMachine->getHasQuarterState());
    }

    void ejectQuarter() {
        cout << "You haven't inserted quarter\n";
    }

    void turnCrank() {
        cout << "You turned but there is no quarter\n";
    }

    void dispense() {
        cout << "You need to pay first\n";
    }
};

class SoldOutState : public State {
    GumBallMachine* gumballMachine;
public:
    SoldOutState(GumBallMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }

    void insertQuarter() {
        cout << "The machine is sold out, no inserting quarter\n";
    }

    void ejectQuarter() {
        cout << "Sorry, you have already turned the crank\n";
    }

    void turnCrank() {
        cout << "Sorry, you have already turned the crank\n";
    }

    void dispense() {
        cout << "No gumball dispensed\n";
    }

};

class HasQuarterState : public State {
    GumBallMachine* gumballMachine;

public:
    HasQuarterState(GumBallMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }

    void insertQuarter() {
        cout << "You can't insert another quarter\n";
    }

    void ejectQuarter() {
        cout << "Quarter returned\n";
        gumballMachine->setState(gumballMachine->getNoQuarterState());
    }
    void turnCrank() {
        cout << "You turned...\n";
        int winner = rand() % 10;
        if (winner == 0 && gumballMachine->getCount() > 1) {
            gumballMachine->setState(gumballMachine->getWinnerState());
        } else {
            gumballMachine->setState(gumballMachine->getSoldState());
        }
    }

    void dispense() {
        cout << "You need to turn the crank\n";
        gumballMachine->setState(gumballMachine->getSoldState());
    }
};

class SoldState : public State {
    GumBallMachine* gumballMachine;
public:
    SoldState(GumBallMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
    void insertQuarter() {
        cout << "Please wait, we are giving you a gumball\n";
    }

    void ejectQuarter() {
        cout << "You can't eject as you haven't insert quarter yet\n";
    }
    void turnCrank() {
        cout << "Turning twice doesn't get you another gumball\n";
    }

    void dispense() {
        gumballMachine->releaseBall();

        if (gumballMachine->getCount() == 0) {
            cout << "We are out of gumballs!!\n";
            gumballMachine->setState(gumballMachine->getSoldOutState());
        } else {
            gumballMachine->setState(gumballMachine->getNoQuarterState());
        }
    }
};

class WinnerState : public State {
    GumBallMachine* gumballMachine;
public:
    WinnerState(GumBallMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
    void insertQuarter() {
        cout << "Not an acceptable State\n";
    }

    void ejectQuarter() {
        cout << "Not an acceptable State\n";
    }
    void turnCrank() {
        cout << "Not an acceptable State\n";
    }

    void dispense() {
        gumballMachine->releaseBall();
        if (gumballMachine->getCount() == 0) {
            gumballMachine->setState(gumballMachine->getSoldOutState());
        } else {
            gumballMachine->releaseBall();
            cout << "YOUR'RE A WINNER!! You got two gumballs!!\n";
            if (gumballMachine->getCount() > 0) {
                gumballMachine->setState(gumballMachine->getNoQuarterState());
            } else {
                gumballMachine->setState(gumballMachine->getSoldOutState());
            }
        }
    }
};

GumBallMachine::GumBallMachine(int count) :
            soldOutState(make_shared<SoldOutState>(this)), 
            noQuarterState(make_shared<NoQuarterState>(this)),
            hasQuarterState(make_shared<HasQuarterState>(this)),
            soldState(make_shared<SoldState>(this)),
            winnerState(make_shared<WinnerState>(this)) {
    this->count = count;
    if (count > 0) 
        state = noQuarterState;
}

int main() {
    GumBallMachine gumball(10);
    for (int i=0; i<10; i++) {
        gumball.insertQuarter();
        gumball.turnCrank();
    }
    // Now easier to add another winner state and any future changes
    return 0;
}