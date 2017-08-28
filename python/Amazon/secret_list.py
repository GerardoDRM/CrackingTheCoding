
def checkSecretList(secret_list, shopping_list):
    ss = [secret_list[i][j] for i in secret_list for j in i]
    indexes = {}
    for idx, f in enumerate(shopping_list):
        if f in indexes:
            indexes[f].append(idx)
        else:
            indexes[f] = [idx]

    started = ss[0] if ss else ""
    if started != 'anything':
        return getResult(ss, shopping_list, started=)
    else:
        for k in indexes:
            if getResult(ss, shopping_list, k) == 1:
                return 1


def getResult(ss, sp, started):
    locs = indexes[started]
    for l in locs:
        if l + len(ss) <= len(shopping_list) and checkEquals(ss, shopping_list):
            return 1
        else:
            return 0


def checkEquals(ss, sp):
    for idx, s in enumerate(ss):
        if s != sp[idx]:
            if s == 'anything' and s != 'nothing':
                pass
            else:
                return False
    return True

if __name__ == "__main__":
