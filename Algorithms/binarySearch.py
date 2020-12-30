def binarySearch(array, target):
    return binarySearchH(array, target, 0, len(array)-1)

def binarySearchH(array, target, left, right):
	if left>right:
		return -1
	mid = (left+right)//2
	if target==array[mid]:
		return mid
	elif target<array[mid]:
		return binarySearchH(array,target,left,mid-1)
	else:
		return binarySearchH(array,target,mid+1,right)
		