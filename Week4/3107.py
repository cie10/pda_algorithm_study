IPv6 = input()

if '::' in IPv6:

    parts = IPv6.split('::')


    if len(parts[0]) > 0 :
        left = parts[0].split(':')
    else:
        left = []

    
    if len(parts[1]) > 0 :
        right = parts[1].split(':')
    else:
        right = []
 
    missing_group = 8 - (len(left) + len(right))

    IPv6_list = left + ['0000'] * missing_group + right


else:

    IPv6_list = IPv6.split(':')


result_list = []

for IPv6 in IPv6_list:
    result_list.append(IPv6.zfill(4))

print(':'.join(result_list))
