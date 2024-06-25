class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        // calculate forward distance
        int index = destination, forwardDistance = 0, backwardDistance = 0, length = distance.length;
        while (index != start) {
            forwardDistance += distance[index++];
            index = index % length;
        }

        // calculate backward distance
        index = destination;
        while (index != start) {
            if(index == 0) index = length;
            backwardDistance += distance[--index];
        }

        return Math.min(backwardDistance, forwardDistance);
    }
}