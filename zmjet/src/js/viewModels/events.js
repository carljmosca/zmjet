define(['ojs/ojcore', 'knockout', 'moment', 'springCollections', 'ojs/ojtable', 'ojs/ojpagingcontrol',
        'ojs/ojpagingtabledatasource', 'ojs/ojcollectiontabledatasource', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata'],
        function (oj, ko, moment, springCollections) {

            function EventsViewModel() {
                var self = this;

                self.serviceURL = 'http://localhost:8080/events';
                self.datasource = ko.observable(); // datasource is an observable so when it is triggered/refreshed, the table component is triggered

                function parseEvents(response) {
                    var st = moment(response.startTime);
                    return {
                        id: response.eventsPK.id,
                        name: response.name,
                        cause: response.cause,
                        st: oj.IntlConverterUtils.dateToLocalIso(st.toDate()),
                        startDate: st.format('MM/DD/YY'),
                        startTime: st.format('hh:mm a')
                    };
                }
                ;
                var Events = oj.Model.extend({
                    parse: parseEvents
                });

                self.createPermalink = function (context) {
                    var link = $(document.createElement('a'));
                    link.attr('href', context.row.link);
                    link.attr('target', 'blank');
                    link.append(oj.Translations.getTranslatedString('readEvents'));
                    $(context.cellContext.parentElement).append(link);
                };

                var EventsCollection = oj.Collection.extend({
                    url: self.serviceURL,
                    customURL: springCollections.mapCollectionURLToDataURL,
                    customPagingOptions: springCollections.mapCollectionsToDataArguments,
                    parse: springCollections.extractContent,
                    fetchSize: 10,
                    model: new Events(),
                    comparator: 'startTime',
                    sortDirection: -1
                });

                self.pagingDatasource = new oj.PagingTableDataSource(new oj.CollectionTableDataSource(new EventsCollection()));
            }

            /*
             * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
             * each time the view is displayed.  Return an instance of the ViewModel if
             * only one instance of the ViewModel is needed.
             */
            return new EventsViewModel();
        }
);
