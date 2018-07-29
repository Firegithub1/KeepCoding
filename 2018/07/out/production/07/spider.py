# 原生爬虫入门

# 需求：爬取熊猫TV王者荣耀分类下的主播名字和人气，并按人气高低排序。

from urllib import request
import re


class Spider():
    url = 'https://www.panda.tv/cate/kingglory'
    root_pattern = '<div class="video-info">([\s\S]*?)</div>'
    name_pattern = '</i>([\s\S]*?)</span>'
    number_pattern = '<span class="video-number">([\s\S]*?)</span>'

    def __fetch_content(self):
        r = request.urlopen(Spider.url)  # 发送 HTTP 请求
        htmls = r.read()
        htmls = str(htmls, encoding='utf-8')
        return htmls

    def __analysis(self, htmls):
        root_html = re.findall(Spider.root_pattern, htmls)

        anchors = []
        # 循环获得 html 标签中的 name，number
        for html in root_html:
            name = re.findall(Spider.name_pattern, html)
            number = re.findall(Spider.number_pattern, html)
            anchor = {'name': name, 'number': number}
            anchors.append(anchor)

        return anchors

    def __refine(self, anchors):
        def l(anchor): return {
            'name': anchor['name'][0].strip(), 'number': anchor['number'][0]}
        return map(l, anchors)

    # 排序
    def __sort(self, anchors):
        # 对人气进行排序，reverse 按降序排列
        anchors = sorted(anchors, key=self.__sort_seed, reverse=True)
        return anchors

    # 排序种子
    def __sort_seed(self, anchor):
        r = re.findall('\d*', anchor['number'])
        number = float(r[0])
        # 若人气带“万”，就把他转换为数字
        if '万' in anchor['number']:
            number *= 10000
        return number

    # 展示结果
    def __show(self, anchors):
        for rank in range(0, len(anchors)):
            # 打印序号，主播名字和人气，并按人气排序
            print('rank  '+str(rank+1)+"  :  " +
                  anchors[rank]['name']+'           '+anchors[rank]['number'])

    # 主方法，主入口
    def go(self):
        htmls = self.__fetch_content()
        anchors = self.__analysis(htmls)
        anchors = list(self.__refine(anchors))
        anchors = self.__sort(anchors)
        self.__show(anchors)


spider = Spider()
spider.go()
