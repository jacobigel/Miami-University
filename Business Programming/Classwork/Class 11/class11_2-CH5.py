s = '  Once upon a time  '
if 'upon' in s:
    print(True)

indx = s.find('upon')
print(indx)

print(s[:indx])

print(s[indx:])


## Given an email address, igeljj@miamioh.edu

def get_domain(email):
    indx1 = email.find('@')
    indx2 = email.find('.', indx1)
    domain = email[indx1+1:indx2]
    return (domain)

email_address = 'igeljj@miamioh.edu'

domain=get_domain(email_address)
print(domain)

email_list = ['igeljj@fsb.miamioh.edu', 'jigel@fuse.net', 'n0m0ref0rtnite@gmail.com',
              'petdatdawg21@yahoo.com']


for email in email_list:
    if email != email_list[-1]:
        print(get_domain(email), end = ', ')
    else:
        print(get_domain(email))
    
