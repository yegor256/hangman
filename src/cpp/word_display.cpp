#include "word_display.hpp"
#include <iostream>

WordDisplay::WordDisplay(size_t word_size)
	: m_buffer(word_size, HIDDEN_LETTER) {
	// initialize the buffer with hidden letters
}

void WordDisplay::Reveal(char letter, const std::vector<size_t>& positions) {
	for (auto pos : positions) {
		m_buffer[pos] = letter;
	}
}

void WordDisplay::Show() const {
	std::cout << "The word: ";
	std::cout << m_buffer << "\n\n";
}
