#include "mistakes.hpp"

Mistakes::Mistakes(int max_amount)
	: m_max_amount(max_amount)
	, m_amount(0) {
}

void Mistakes::MakeOne() {
	++m_amount;
}

int Mistakes::GetAmount() const {
	return m_amount;
}

int Mistakes::GetMaxAmount() const {
	return m_max_amount;
}

int Mistakes::IsMaxAmountReached() const {
	return m_amount >= m_max_amount;
}
