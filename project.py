class Basket: 
    def __init__(self):
        self.radius: float

class Player:
    def __init__(self):
        self.height: float
        self.weight: float

class Ball:
    def __init__(self):
        self.radius: float
        self.weight: float
    

class Point:
    def __init__(self):
        self.value: int 

class twoPoint(Point):
    pass 

class threePoint(Point):
    pass 

class BasketShot: 
    def __init__(self):
        self.shotPoints: Point 

class Score:
    def __init__(self):
        self.gameShots: List[BasketShot]

class Game:
    def __init__(self):
        self.gameBasket: Basket
        self.gamePlayer: Player
        self.gameBall: Ball
        self.gravity: float
