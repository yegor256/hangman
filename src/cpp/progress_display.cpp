//
// Created by zeronsix on 16.03.2020.
//

#include "progress_display.hpp"
#include <iostream>

ProgressDisplay::ProgressDisplay(Mistakes &mistakes)
	: m_mistakes(mistakes) {
}

void ProgressDisplay::ShowHit() const {
	std::cout << "Hit!\n";
}

void ProgressDisplay::ShowMiss() const {
	std::cout << "Missed, mistake " << m_mistakes.GetAmount() << " out of "
		<< m_mistakes.GetMaxAmount() << "\n";
}

void ProgressDisplay::ShowWin() const {
	std::cout << "You won!\n";
}

void ProgressDisplay::ShowLoss() const {
	std::cout << "You lost.\n";
}
