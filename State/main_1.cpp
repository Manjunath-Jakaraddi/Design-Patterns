#include<iostream>

using namespace std;
class GumBallMachine {
    const static int SOLD_OUT       = 0;
    const static int NO_QUARTER     = 1;
    const static int HAS_QUARTER    = 2;
    const static int SOLD           = 3;

    int state = SOLD_OUT;
    int count = 0;
public:
    GumBallMachine(int count) {
        this->count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    void insertQuarter() {
        if (state == HAS_QUARTER) {
            cout << "You can't insert another quarter\n";
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            cout << "You inserted a quarter\n";
        } else if (state == SOLD_OUT) {
            cout << "The machine is sold out, no inserting quarter\n";
        } else if (state == SOLD) {
            cout << "Please wait, we are giving you a gumball\n";
        }
    }

    void ejectQuarter() {
        if (state == HAS_QUARTER) {
            cout << "Quarter returned\n";
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            cout << "You haven't inserted quarter\n";
        } else if (state == SOLD_OUT) {
            cout << "Sorry, you have already turned the crank\n";
        } else if (state == SOLD) {
            cout << "You can't eject as you haven't insert quarter yet\n";
        }
    }
    void turnCrank() {
        if (state == HAS_QUARTER) {
            cout << "You turned...\n";
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            cout << "You turned but there is no quarter\n";
        } else if (state == SOLD_OUT) {
            cout << "Sorry, you have already turned the crank\n";
        } else if (state == SOLD) {
            cout << "Turning twice doesn't get you another gumball\n";
        }
    }

    void dispense() {
        if (state == HAS_QUARTER) {
            cout << "You need to turn the crank\n";
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            cout << "You need to pay first\n";
        } else if (state == SOLD_OUT) {
            cout << "No gumball dispensed\n";
        } else if (state == SOLD) {
            cout << "A gumball comes rolling out of the machine\n";
            count--;
            if (count == 0) {
                cout << "We are out of gumballs!!";
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        }
    }
};

int main() {
    GumBallMachine gumball(3);
    gumball.insertQuarter();
    gumball.insertQuarter();
    gumball.turnCrank();
    gumball.turnCrank();
    gumball.turnCrank();
    // The problem with above solutions is when a change comes introducing another state
    // we need to update all the if else conditions with another additional statement
    // opposing the open-close principle
    // Solution: Introduce the state pattern
    return 0;
}