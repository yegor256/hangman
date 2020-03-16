#include "user_input.hpp"
#include <iostream>

char UserInput::InputLetter() const {
	char c = 0;
	std::cout << "Guess a letter: ";
	std::cin >> c;
	return c;
}
