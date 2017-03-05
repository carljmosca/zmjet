define(['ojs/ojcore', 'knockout', 'moment', 'springCollections', 'ojs/ojtable', 'ojs/ojpagingcontrol', 'ojs/ojpagingtabledatasource', 'ojs/ojcollectiontabledatasource', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata'],
        function (oj, ko, moment, springCollections) {

            function MonitorsViewModel() {
                var self = this;

                self.serviceURL = 'http://localhost:8080/frames';
                self.datasource = ko.observable(); // datasource is an observable so when it is triggered/refreshed, the table component is triggered

                function parseMonitor(response) {
                    var ts = moment(response.timeStamp);
                    return {
                        id: response.framesPK.frameId,
                        type: response.type,
                        score: response.score,
                        ts: oj.IntlConverterUtils.dateToLocalIso(ts.toDate()),
                        tsDate: ts.format('MM/DD/YY'),
                        tsTime: ts.format('hh:mm a')
                    };
                }
                ;
                var Monitor = oj.Model.extend({
                    parse: parseMonitor
                });

                self.createPermalink = function (context) {
                    var link = $(document.createElement('a'));
                    link.attr('href', context.row.link);
                    link.attr('target', 'blank');
                    link.append(oj.Translations.getTranslatedString('readMonitor'));
                    $(context.cellContext.parentElement).append(link);
                };

                var MonitorCollection = oj.Collection.extend({
                    url: self.serviceURL,
                    customURL: springCollections.mapCollectionURLToDataURL,
                    customPagingOptions: springCollections.mapCollectionsToDataArguments,
                    parse: springCollections.extractContent,
                    fetchSize: 10,
                    model: new Monitor(),
                    comparator: 'timeStamp',
                    sortDirection: -1
                });

                self.pagingDatasource = new oj.PagingTableDataSource(new oj.CollectionTableDataSource(new MonitorCollection()));
            }

            /*
             * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
             * each time the view is displayed.  Return an instance of the ViewModel if
             * only one instance of the ViewModel is needed.
             */
            return new MonitorsViewModel();
        }
);
