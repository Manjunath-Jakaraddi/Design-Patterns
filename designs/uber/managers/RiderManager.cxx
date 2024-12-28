#include <memory>
#include <mutex>
#include <unordered_map>
#include "IRiderManager.cxx"
#include "Rider.cxx"

class RiderManager : IRiderManager {
    std::unordered_map<std::string, std::shared_ptr<Rider>> rider_map;
    std::mutex lk;
    
    bool addRider(std::string name, std::shared_ptr<Rider> rider) override {
        std::lock_guard<std::mutex> guard(lk);
        return rider_map.emplace(name, rider).second;
    }

    std::shared_ptr<Rider> getRider(std::string name) override {
        std::lock_guard<std::mutex> guard(lk);
        return rider_map[name];
    }
};