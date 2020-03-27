# PokerCalc 

Series of poker probability simulators:

First simulator (SimulateVsHand): 
Takes 2-4 players' pocket cards (can easily be extended to any number of players) and the current community cards.  Calculates their odds of winning and tying the pot if played to showdown (known as pot equity).  Number of iterations for precise estimate: ~1,000,000

Second simulator (SimulateVsRange):
Takes a player's pocket cards and an opponent's range of possible pocket cards.  Calculates pot equity for both the player and the range.  Iterations for precise estimate: ~100,000 each.

TODO: 
- Documentation
- Make encapsulation adhere to java conventions
- Experimentally determine equity of each pair pocket cards vs a pair of pocket cards 
(needed for Range, currently using dataset from http://www.pokerhandrange.com/)
- GUI for simulators
- Perhaps extend into a playable game simulator (i.e add betting + more GUI)
