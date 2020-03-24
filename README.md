# PokerCalc
Series of poker probability calculators

Work in progress.  Right now we can take 2-4 pocket hands (and could easily be expanded to any number of hands, if desired), and simulate each player's chances of winning the pot outright, along with their chances of splitting it, after the flop, turn, and river have been dealt.  When you multiply this percentage by the amount of money in the pot, it is known as pot equity.  The next step is to extend to calculate equity of a player's hand vs another player's range.  I also have all the logic necessary to produce a poker simulator, which could be a fairly simple side-step from this point in the project.  

Workflow: 
Done:
-Create representations for a card of a given suit+value
-Create a representation of a deck 
-Be able to take a 5-card hand and return its exact value, including kickers
-Be able to take a group of 7 cards, i.e table cards + hole cards, and return the best 5-card hand
-Simulate which of two-four pocket hands will win for a given draw, and repeat a large amount of times to approximate probability.
Next:
-Create a range calculator, i.e get the set of hands reflecting the top n% of poker hands
-Extend the simulation for hand vs range
