#include <memory>
#include "Rider.cxx"

class IRiderManager {
    bool virtual addRider(std::string name, std::shared_ptr<Rider> rider) = 0;
    std::shared_ptr<Rider> virtual getRider(std::string name) = 0;
};