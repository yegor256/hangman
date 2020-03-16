cmake_minimum_required(VERSION 3.15)
project(hangman)

set(CMAKE_CXX_STANDARD 17)
file(GLOB SOURCES "src/cpp/*.cpp" "src/cpp/*.hpp")
add_executable(hangman ${SOURCES})