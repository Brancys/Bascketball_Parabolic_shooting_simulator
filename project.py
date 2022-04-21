import math

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
        self.speed: float
    

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
        self.launchingAngle: float
        self.t: float
     
    def getDataFromUser(self):
        self.gameBall.speed =raw_input("Digite Velocidad inicial del balon: ")
        self.gamePlayer.height = raw_input("Digite Altura del Jugador: ")
        self.gravity = raw_input("Digite La gravedad del planeta: ")*-1
        self.launchingAngle = raw_input("Digite el angulo del lanzamiento en grados: ")
        self.t = raw_input("Digite el momento t en segundos a consultar:")
        

input_test = Game()
ball_test = Ball()
player_test = Player()
input_test.gameBall = ball_test
input_test.gamePlayer = player_test

input_test.getDataFromUser()
print("Datos ingresados:")
print("Velocidad inicial (m/s):" +input_test.gameBall.speed)
print("Altura inicial (m):" +input_test.gamePlayer.height)
print("Gravedad del lugar (m/s^2):" +input_test.gravity)
print("Angulo de lanzamiento (º):" +input_test.angle)
print("Momento a revisar (s):" +input_test.gameBall.speed)
print("Datos obtenidos correctamente")




        
            
