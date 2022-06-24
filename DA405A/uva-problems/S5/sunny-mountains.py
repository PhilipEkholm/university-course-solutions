import sys
import math

# 1. Sort all the points by the x-coordinate. Highest goes first.
# 2. For the first mountain (which the whole mountain is always covered)
#    the sunline is given by the euclidean distance between mountain bottom and top.
#    given by pythagorean theorem.
# 3. For other mountains, calculate total line like in (2), but only add the quota given
#    by the geometric similarity.
#
# Given two triangles ABC and DEF which are geometrically similar. The part of the mountain
# covered by sunlight is given by: AB = (DE * AC) / DF, where DEF is the mountain in front 
# of the mountain 'longer back'.

counter = 0
points = []

class Point:
	def __init__(self, x, y):
		self.x = x
		self.y = y

def getEuclidDistance(p, q):
	return math.sqrt((q.x - p.x)**2 + (q.y - p.y)**2)

def sortByX(element):
	return element.x

testCases = int(sys.stdin.readline().rstrip())

for i in range(0, testCases):
	numberOfPoints = int(sys.stdin.readline().rstrip())

	#Add each point first
	for j in range(0, numberOfPoints):
		x, y = [int(s) for s in sys.stdin.readline().split()]
		points.append(Point(x, y))

	#Calculate sunbeam line
	sunbeamLine = 0
	currentHighestPoint = 0
	sortedPoints = sorted(points, key=sortByX)

	for j in range(numberOfPoints-1, 0, -1):
		#Only calculate anything if sunbeams actually touch the mountain
		if sortedPoints[j - 1].y > currentHighestPoint:
			if currentHighestPoint <= 0:
				sunbeamLine += getEuclidDistance(sortedPoints[j], sortedPoints[j - 1])
			else:
				#Only a part of mountain is lit, use geometric similarity
				mountainSide = getEuclidDistance(sortedPoints[j], sortedPoints[j - 1])
				pointDifference = sortedPoints[j - 1].y - currentHighestPoint
				yDistance = sortedPoints[j - 1].y - sortedPoints[j].y

				sunbeamLine += (mountainSide * pointDifference) / yDistance

			currentHighestPoint = sortedPoints[j - 1].y

	print(format(sunbeamLine, ".2f"))
	points.clear()








