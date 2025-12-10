use demo002
INSERT INTO DiningTable (seats, statusTable) VALUES
(4,  'Empty'),
(2,  'Booked'),
(6,  'Using'),
(8,  'Empty'),
(4,  'Using'),
(10, 'Booked'),
(2,  'Empty'),
(6,  'Booked'),
(12, 'Empty'),
(4,  'Booked'),
(8,  'Using');

Insert into Account (username , password) 
values('doquanghuy' , '11'),
('phambinhhoan' , '22'),
('trinhquangtruong' ,'33'),
('phamngoctu' , '44');

INSERT INTO Employee (Name, DoB, Gender, Phone, Address, Salary, role, username)
VALUES
-- Đỗ Quang Huy
('Đỗ Quang Huy', '2000-05-15', 'Nam', '0901234567', '123 Đường Nguyễn Trãi, Hà Nội', 10000000.00, 'Employee', 'doquanghuy'),

-- Trịnh Quang Trường
('Trịnh Quang Trường', '1999-11-20', 'Nam', '0919876543', '456 Phố Điện Biên Phủ, Đà Nẵng', 12500000.00, 'Employee', 'trinhquangtruong'),

-- Phạm Bình Hoàn
('Phạm Bình Hoàn', '2001-08-01', 'Nam', '0987654321', '789 Quận 1, TP. Hồ Chí Minh', 9800000.00, 'Employee', 'phambinhhoan'),

-- Phạm Ngọc Tú
('Phạm Ngọc Tú', '1998-03-25', 'Nam', '0971122334', '101 Đường Trần Hưng Đạo, Cần Thơ', 11200000.00, 'Employee', 'phamngoctu');

