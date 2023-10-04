import cv2


im = cv2.imread('C:\\Users\\HP\\Downloads\\vmr.jpg')

gray_image = cv2.cvtColor(im, cv2.COLOR_BGR2GRAY)

invert = 255 - gray_image

blur = cv2.GaussianBlur(invert, (21,21), 0)

inv_blur = 255 - blur

pencil_sketch = cv2.divide(gray_image, inv_blur, scale=256.0)

cv2.imshow('Original Image', im)
cv2.imshow('New Image', pencil_sketch)
cv2.waitKey(0)
