cmake_minimum_required(VERSION 3.10)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

project(composite VERSION 1.0)

add_compile_options("-g")
add_executable(composite main.cpp)