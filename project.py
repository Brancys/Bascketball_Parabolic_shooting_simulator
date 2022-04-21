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
        self.shotSpeed: float

class Score:
    def __init__(self):
        self.gameShots: List[BasketShot]

class Game:
    def __init__(self):
        self.gameBasket: Basket
        self.gamePlayer: Player
        self.gameBall: Ball
        self.gravity: float
     
    def getDataFromUser(self):
        self.gamePlayer.height = raw_input("Digite Velocidad inicial del balon: ")
        y0 = raw_input("Digite Altura del Jugador: ")
        gravity = raw_input("Digite La gravedad del planeta: ")*-1
        angle = raw_input("Digite el angulo del lanzamiento: ")
            
