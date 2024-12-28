cmake_minimum_required(VERSION 3.10)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

project(Uber VERSION 1.0)
add_executable(Uber main.cxx)


include(FetchContent)
FetchContent_Declare(
    googletest
    URL https://github.com/google/googletest/archive/03597a01ee50ed33e9dfd640b249b4be3799d395.zip
)
FetchContent_MakeAvailable(googletest)


enable_testing()
add_executable(hello hello.cxx)
target_link_libraries(hello GTest::gtest_main)

include(GoogleTest)
gtest_discover_tests(hello)
