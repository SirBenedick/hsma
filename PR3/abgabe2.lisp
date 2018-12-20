Übungsblatt 2:
Aufgabe 1
a) 
(defun my-reverse (wert)
	(cond((null wert) wert)
	(T (append(my-reverse(cdr wert))(list(car wert))))))
	
	
b)
(defun my-reverseR (wert)
	(cond((null wert) wert)
	((listp (car wert))(append(my-reverseR(cdr wert)) 
	(list (my-reverseR(car wert)))))
	(T (append(my-reverseR(cdr wert))(list(car wert))))))

c) 
(defun rotiere (liste)
	(cond ((null liste) liste)
	(T (append (cdr liste)(list(car liste))))))
	
d) 
(defun neues-vorletztes (element liste)
	(cond ((null liste) element)
	(T (append (reverse(cdr (reverse liste)))(list element)(list(car (reverse liste)))))))
	
e) 
(defun my-length (liste)
	(cond ((null liste) 0)
	(T (+ 1 (my-length(cdr liste))))))
	

f) 
(defun my-lengthR (liste) 
	(cond ((null liste) 0)
	((listp (car liste))(+ (my-lengthR(car liste)) (my-lengthR(cdr liste))))
	(T (+ 1 (my-lengthR(cdr liste))))))
