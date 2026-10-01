func minEatingSpeed(piles []int, h int) int {
    maxPile := 0
    for _, v := range piles {
        if v > maxPile {
            maxPile = v
        }
    }

    left, right := 1, maxPile
    ans := maxPile

    for left <= right {
        mid := left + (right-left)/2
        
        if canFinish(piles, h, mid) {
            ans = mid
            right = mid - 1 
        } else {
            left = mid + 1
        }
    }
    return ans
}

func canFinish(piles []int, h int, k int) bool {
    hours := 0
    for _, pile := range piles {
        hours += (pile + k - 1) / k 
    }
    return hours <= h
}