# EO Cactoos primitives
It is a proposal for https://github.com/yegor256/cactoos

### Goal
OO, EO but readable.

### Issues
If you developp with EO in mind, then it is almost imposible to get collisions:
character.Lowercased, string.Lowercased, but if the circumstances arrive then
you can use them with the dot prefixes.

### Proposal:
```
import cactoos.convertible.character.Lowercased;
import cactoos.comparable.character.Equal;
new Equal(new Lowercased(symbol), new Lowercased(letter.symbol())).are();
```

### Experimental:
```
import cactoos.convertible.character.array.Lowercased;
import cactoos.comparable.character.Equal;
new Equal(new Lowercased(symbol, letter.symbol())).are();
```


