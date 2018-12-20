Aufgabe 1:
Bsp.Format: (mobilep '(10 (11 (2 3 3) 8) (9 9 (1 (2 1 1) 4))))
--------------------------------------------------------------
(defun mobilep (mobile)
    (let ((rechts nil)(links nil)(gewichtl nil)(gewichtr nil)) 
        (cond ( (NOT (listp mobile)) (list mobile))
            (T (setf links (cadr mobile))(setf rechts (caddr mobile))(setf gewichtl (mobilep links))(setf gewichtr (mobilep rechts))
                (cond ( (or (not gewichtl) (not gewichtr)) nil)
                    ((eql (car gewichtl) (car gewichtr))(list (+ (car gewichtl) (car gewichtr) (car mobile)))))))))
--------------------------------------------------------------


Aufgabe 2:
a)
(defun liste-ohne-zahlen (liste)
(let ((buchs nil))
	(cond ((null liste) buchs)
	((numberp (car liste))(append buchs(liste-ohne-zahlen(cdr liste))))
	(T (append (append buchs(list(car liste)))(liste-ohne-zahlen(cdr liste)))))))
	
b)
(defun funkdef-1arg (fktname op const var)
	(list 'defun fktname (list var) (list op var const)))

c) 
(defun funkdef-1arg+eval(fktname op const var arg)
	(eval (funkdef-1arg fktname op const var))
	(eval (list fktname arg)))
	
d) Mit Funcall:
(defun listenop (op liste1 liste2)
	(funcall op liste1 liste2))

e)
(defun key-unterliste (needle haystack)
    (cond 
        ((NOT haystack)nil)
        ((key-unterliste-test needle (car haystack))(car haystack))
        (T(key-unterliste needle (cdr haystack)))))

(defun key-unterliste-test (needle haystack)
    (member needle (list (car haystack))))
